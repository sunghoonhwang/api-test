<template>
    <b-row class="py-3 my-2">
      <b-col cols="12" lg="8" offset-lg="2">
        <h3>TestRun</h3>
        <b-form>
          <b-form-row>
            <b-form-group md="5" class="mb-3" label="testjobId" label-for="street_address">
              <b-form-input id="street_address" :value="orderInfo.testId" required />
            </b-form-group>      
            <b-form-group md="2" class="mb-3" label="Method" label-for="credit_card_expiration_month">
              <b-select name="credit_card_expiration_month" id="credit_card_expiration_month" :value="orderInfo.creditCardInfo.creditCardExpirationMonth">
                  <option value="1">GET</option>
                  <option value="2">POST</option>
              </b-select>
            </b-form-group>      
            <b-form-group md="5" class="mb-3" label="URL" label-for="street_address">
              <b-form-input id="street_address" :value="orderInfo.url" required />
            </b-form-group>      
            <b-form-group md="5" class="mb-3" label="Body" label-for="street_address">
              <b-form-input id="street_address" :value="orderInfo.body" required />
            </b-form-group>      
          </b-form-row>
          <b-form-row>
            <b-button variant="primary" @click="checkout">Run</b-button>
          </b-form-row>
        </b-form>
      </b-col>
    </b-row>
  </template>
  
  <script>
  import {mapGetters} from 'vuex'
  
  export default {
    name: 'Checkout',
    computed: mapGetters({
    orderInfo: 'testrun/orderInfo'
  }),
    methods: {
      checkout() {
        this.$store.dispatch('testrun/checkout')
        // alert("내용 입력");
        // this.$router.push("/order")
      }
    }
  }
  </script>
