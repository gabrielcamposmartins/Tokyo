<template>
  <div class="d-flex flex-column w-100">
    <div class="flex flex-row-reverse justify-content-end w-100">
      <button class="btn btn-primary" @click="openModalTransferencia">{{ 'Nova transferência' }}</button>
    </div>
    <div class="overflow-auto" v-if="transferencias.length > 0">
      <b-table id="my-table" :items="transferencias" small>
        <template #cell(origem)="data">
          {{ data.item.origem.id }}
        </template>
        <template #cell(destino)="data">
          {{ data.item.destino.id }}
        </template>
      </b-table>
      <b-pagination
        v-model="currentPage"
        :total-rows="totalElements"
        :per-page="perPage"
        @update:model-value="pageChanged"
        aria-controls="my-table"
        size="sm"
      ></b-pagination>
    </div>

    <b-modal id="modal-transferencia" ref="modal" title="Nova Transferência" hide-footer>
      <b-form class="d-flex flex-column">
        <div class="mb-3">
          <label for="">Data</label>
          <Datepicker disabledTime  label="Data" v-model="form.dataTransferencia" :format="formatDate" inputFormat="dd/MM/yyyy" />
        </div>
        <ContasSelect v-model="form.origem" label="Conta de Origem" :contas="contas"/>
        <ContasSelect v-model="form.destino" label="Conta de Destino" :contas="contas"/>
        <b-form-group label="Valor" label-for="valor" class="mb-3 w-100">
          <b-form-input id="valor" v-model="form.valor" type="number" required></b-form-input>
        </b-form-group>
        <b-button type="submit" @click="submitForm" variant="primary">Enviar</b-button>
      </b-form>
    </b-modal>
  </div>
</template>
<script>
import ContasSelect from "./ContasSelect.vue";
import Datepicker from 'vue3-datepicker';

export default {
  name: "Transferencias",
  components: {
    ContasSelect,
    Datepicker,
  },
  props: {
    transferencias: Array,
    totalElements: Number,
    currentPage: Number,
    contas: Array,
  },
  data() {
    return {
      msg: "Hello, World!",
      account: null,
      perPage: 5,
      currentPage: 1,
      form: {
        origem: '',
        destino: '',
        dataTransferencia: null,
        valor: null,
      },
    };
  },
  methods: {
    pageChanged(newPage) {
      this.$emit("page-changed", newPage);
    },
    openModalTransferencia() {
      this.form = {
        origem: null,
        destino: null,
        dataTransferencia: null,
        valor: null,
      };
      this.$refs.modal.show();
    },
    submitForm() {
      this.form.origem = this.form.origem.id;
      this.form.destino = this.form.destino.id;
      this.$emit("cadastro-transferencia", this.form);
      this.$refs.modal.hide();
    },
    formatDate(date) {
      if (!date) return '';
      const options = { day: '2-digit', month: '2-digit', year: 'numeric' };
      return new Intl.DateTimeFormat('pt-BR', options).format(new Date(date));
    },
  },
};
</script>
