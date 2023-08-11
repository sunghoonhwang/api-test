<template>
    <b-row class="py-3 my-2">
      <b-col cols="12" lg="8" offset-lg="2">
        <h3>TestJob</h3>
        <b-form>
          <b-form-row>
            <b-form-group md="2" class="mb-3" label="Method" label-for="credit_card_expiration_month">
              <b-select name="credit_card_expiration_month" id="credit_card_expiration_month" :value="orderInfo.creditCardInfo.creditCardExpirationMonth">
                  <option value="1">GET</option>
                  <option value="2">POST</option>
              </b-select>
            </b-form-group>      
            <b-form-group md="5" class="mb-3" label="URL" label-for="street_address">
              <b-form-input id="street_address" :value="orderInfo.address.streetAddress" required />
            </b-form-group>      
            <b-form-group md="5" class="mb-3" label="Body" label-for="street_address">
              <b-form-input id="street_address" :value="orderInfo.address.streetAddress" required />
            </b-form-group>      
          </b-form-row>
          <b-form-row>
            <b-form-group md="2" class="mb-3" label="Type" label-for="credit_card_expiration_month">
              <b-select name="credit_card_expiration_month" id="credit_card_expiration_month" :value="orderInfo.creditCardInfo.creditCardExpirationMonth">
                  <option value="1">Variable</option>
                  <option value="2">Global</option>
              </b-select>
            </b-form-group>      
            <b-form-group md="5" class="mb-3" label="Key" label-for="street_address">
              <b-form-input id="street_address" :value="orderInfo.address.streetAddress" required />
            </b-form-group>      
            <b-form-group md="2" class="mb-3" label="Value" label-for="credit_card_cvv">
              <b-form-input id="credit_card_cvv" :value="orderInfo.creditCardInfo.cvv" required />
            </b-form-group>
          </b-form-row>
          <b-form-row>
            <b-button variant="primary" @click="checkout">Save</b-button>
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
      orderInfo: 'cart/orderInfo'
    }),
    methods: {
      checkout() {
        this.$store.dispatch('testjob/checkout')
        this.$router.push("/order")
      }
    }
  }
  </script>
