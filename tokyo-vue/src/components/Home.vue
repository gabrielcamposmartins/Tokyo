<template>
  <div>
    <ContasSelect :contas="contas"/>
    <h1>{{ homeMessage }}</h1>
    <button @click="test()" ></button>
  </div>
</template>
<script>
import ContasSelect from './ContasSelect.vue'

export default {
  name: 'Home',
  components: {
    ContasSelect,
  },
  data() {
    return {
      homeMessage: 'Selecione uma conta para começar',
      contas: ['001', '002'],
    }
  },
  methods: {
    test() {
      alert('Hello, World!');
    }
  }
}
</script>
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
