<template>
    <div class="d-flex-column">
      <label for="conta" class="form-label">{{label}}</label>
      <select v-model="account" @change="contaSelecionada" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
        <option selected>Selecione a conta</option>
        <option v-for="conta in contas" :key="conta.id" :value="conta">{{conta.id}}</option>
      </select>
    </div>
</template>

<script>
export default {
  name: "ContasSelect",
  props: {
    contas: Array,
    modelValue: Object,
    label: String,
  },
  data() {
    return {
      msg: "Hello, World!",
      account: null,
    };
  },
  methods: {
    contaSelecionada() {
      this.$emit("update:modelValue", this.account);
      this.$emit("contaSelecionada", this.account);
    },
  },
};
</script>