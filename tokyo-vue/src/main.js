import { createApp } from 'vue'
import App from './App.vue'
import store from './store'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue-next/dist/bootstrap-vue-next.css'
import { BTable, BPagination, BModal, BFormGroup, BFormInput, BButton, BToast, toastPlugin } from 'bootstrap-vue-next'

createApp(App)
.use(store)
.use(toastPlugin)
.component('b-table', BTable)
.component('b-pagination', BPagination)
.component('b-modal', BModal)
.component('b-form-group', BFormGroup)
.component('b-form-input', BFormInput)
.component('b-button', BButton)
.component('b-toast', BToast)
.mount('#app')
