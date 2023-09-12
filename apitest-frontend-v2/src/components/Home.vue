<template>
  <b-container>
    <b-jumbotron class="text-center mb-0" :style="{backgroundColor: bannercolor}">
      <b-container>
        <h1 class="jumbotron-heading">
            ★★ Accelerating API Quality Through Testing ★★
        </h1>
        <p class="lead text-muted">
            Automate and fit API testing into your team’s continuous delivery pipeline with the next generation tool built for validation of REST, SOAP, microservices, and other back-end services.
        </p>
      </b-container>
    </b-jumbotron>

    <b-container class="py-5 bg-light">
        <Products />        
    </b-container>
  </b-container>
</template>

<script>
import {mapState} from 'vuex'

import Products from '@/components/Products.vue'

export default {
  name: 'Home',
  components: {
    Products
  },
  computed: {
    ...mapState({
      bannercolor: state => state.bannercolor
    })
  }
}
</script>

