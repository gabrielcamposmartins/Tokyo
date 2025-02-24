<template>
  <div>
    <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
      <option selected>Selecione a conta</option>
      <option v-for="conta in contas" :key="conta" :value="conta">{{conta}}</option>
    </select>
  </div>
</template>

<script>
export default {
  name: "ContasSelect",
  props: {
    contas: Array,
  },
  data() {
    return {
      msg: "Hello, World!",
    };
  },
  methods: {
    test() {
      alert("Hello, World!");
    },
  },
};
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
