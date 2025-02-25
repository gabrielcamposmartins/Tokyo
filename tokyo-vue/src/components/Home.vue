<template>
  <div class="m-5 d-flex flex-column align-items-center">
    <div class="d-flex align-items-center justify-content-between w-100">
      <ContasSelect :contas="contas" @contaSelecionada="preencherTabela" />
      <h1 v-if="contaSelecionada">{{ "Saldo:" + contaSelecionada.saldo }}</h1>
    </div>
    <h1 v-if="!contaSelecionada">{{ homeMessage }}</h1>
    <Transferencias
      v-if="contaSelecionada"
      :transferencias="transferencias"
      :contas="contas"
      :totalElements="totalElements"
      :current-page="page"
      @page-changed="handlePageChange"
      @cadastro-transferencia="cadastrarTransferencia"
    />
  </div>
</template>
<script>
import ContasSelect from "./ContasSelect.vue";
import Transferencias from "./Transferencias.vue";
import { getContas } from "../services/contas";
import {
  getTransferencias,
  createTransferencia,
} from "../services/transferencias";

export default {
  name: "Home",
  components: {
    ContasSelect,
    Transferencias,
  },
  data() {
    return {
      homeMessage: "Selecione uma conta para começar",
      contas: [],
      transferencias: [],
      contaSelecionada: null,
      totalElements: null,
      page: 0,
      size: 5,
    };
  },
  methods: {
    preencherTabela(contaSelecionada) {
      this.contaSelecionada = contaSelecionada;
      this.buscarTransferencias(contaSelecionada.id);
    },
    cadastrarTransferencia(transferencia) {
      createTransferencia(transferencia)
        .then(() => {
          this.buscarTransferencias(this.contaSelecionada.id);
        })
        .catch((error) => {
          alert(error);
        });
    },
    buscarTransferencias(id) {
      const params = {
        id: id,
        page: this.page - 1,
        size: this.size,
      };
      getTransferencias(params)
        .then((response) => {
          if (Array.isArray(response.content)) {
            this.totalElements = response.totalElements;
            this.transferencias = response.content;
          } else {
            console.error("Expected an array but got:", response);
          }
        })
        .catch((error) => {
          alert(error);
        });
    },
    handlePageChange(newPage) {
      this.page = newPage;
      this.buscarTransferencias();
    },
    buscarContas() {
      getContas()
        .then((response) => {
          this.contas = response;
        })
        .catch((error) => {
          alert(error);
        });
    },
  },
  mounted() {
    this.buscarContas();
  },
};
</script>
