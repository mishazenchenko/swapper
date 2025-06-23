<template>
  <b-container fluid="xl">
    <page-title :description="$t('depo.pageDescription')" />
    <h1>sdfsfsdfdsf</h1>
  </b-container>
</template>
<script>
import PageTitle from '@/components/Global/PageTitle';
import LoadingBarMixin from '@/components/Mixins/LoadingBarMixin';
import { useI18n } from 'vue-i18n';
export default {
  name: 'DepoHostBootOrder',
  components: { PageTitle },
  mixins: [LoadingBarMixin],
  beforeRouteLeave(to, from, next) {
    this.hideLoader();
    next();
  },
  data() {
    return {
      $t: useI18n().t,
    };
  },
  created() {
    this.startLoader();
    this.endLoader();
  },
};
</script>
<style lang="scss" scoped>
.example-class {
  /* Styles go here */
}
</style>
