<template>
  <div class="hello">
    <b-card
    header="오늘 해야 할 일"
    style="max-width: 40rem; margin: auto; margin-top: 10vh;"
    class="mb-2"
    border-variant="info"
    align="left">

      <b-form-group id="to-do-input">
        <b-container fluid>
          <b-row class="my-1">
            <b-col sm="10">
              <b-form-input v-model="newToDoItemRequest.title" type="text"
                        placeholder="새 할 일을 적으세요." v-on:keyup.enter="createToDo"/>
            </b-col>
            <b-col sm="2">
              <b-button variant="outline-primary" v-on:click="createToDo">추가</b-button>
            </b-col>
          </b-row>
        </b-container>
      </b-form-group>

      <b-list-group v-if="toDoItems && toDoItems.length">
         <b-list-group-item
          v-for="toDoItem of toDoItems"
          v-bind:data="toDoItem.id"
          v-bind:key="toDoItem.id" style="display:flex;">
          <b-form-checkbox
             v-model="toDoItem.done"
             v-on:change="markDone(toDoItem)">
           </b-form-checkbox>
           <span v-if="toDoItem.done" style="text-decoration: line-through; color:#D3D3D3;">
            {{toDoItem.title}}</span>
           <span v-else>{{toDoItem.title}}</span>
           <b-col align="right">
             <b-button variant="outline-primary" v-model="toDoItem.id" type="text"
              v-on:click="deleteToDo(toDoItem)">삭제</b-button>
           </b-col>
         </b-list-group-item>
      </b-list-group>
  </b-card>
  </div>
</template>

<script>
import axios from 'axios'

let baseUrl = 'http://127.0.0.1:5000/todo/'
export default {
  name: 'hello',
  data: () => {
    return {
      toDoItems: [],
      newToDoItemRequest: {} // 새 To Do Item을 저장 할 오브젝트
    }
  },
  methods: {
    initToDoList: function () {
      let vm = this
      axios.get(baseUrl)
        .then(response => {
          vm.toDoItems = response.data.map(r => r.data)
        })
        .catch(e => {
          console.log('error : ', e)
        })
    },
    createToDo: function (event) {
      event.preventDefault()
      let vm = this
      if (!vm.newToDoItemRequest.title) return // To Do Item의 제목이 없으면 아무것도 안하고 리턴
      axios.post(baseUrl, vm.newToDoItemRequest) // 아니면 스프링 부트 RESTful API에 POST 콜
        .then(response => {
          console.log(response)
          vm.initToDoList()
          vm.newToDoItemRequest = {}
        })
        .catch(error => {
          console.log(error)
        })
    },
    deleteToDo: function (toDoItem) {
      let vm = this
      console.log(toDoItem.id)
      axios.delete(baseUrl, {
        data: {
          id: toDoItem.id
        }
      })
        .then(response => {
          console.log(response)
          vm.initToDoList()
        })
        .catch(error => {
          console.log(error)
        })
    },
    markDone: function (toDoItem) {
      if (!toDoItem) return
      let vm = this
      axios.put(baseUrl, toDoItem)
        .then(response => {
          vm.initToDoList()
        })
        .catch(error => {
          console.log(error)
        })
    }
  },
  created () {
    this.initToDoList()
  }
}
</script>
