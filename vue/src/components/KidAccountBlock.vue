<template>
  <div>
      <div class="kid-block">
        <button v-on:click="addKid">add kids</button>
        <!-- <ul>
          <li v-for="kid in kids" v-bind:key="kid.id">
              <h2>{{ kid.name }}</h2>
              <p>Steps: {{ kid.steps }}</p>
              <p>Hours of Activity: {{ kid.hours }}</p>
              <button>Log Hours/Steps</button>
              <button>View Account</button>
              <button>Remove Kid</button>
          </li>
        </ul> -->
      </div>
  </div>
</template>

<script>
import KidService from '../services/KidService'

export default {
  data() {
    return {
      newKid: {
        name: "jean",
        steps: 1
      }
    }
  },
  methods: {
    addKid() {
      console.log("adding kid")
      KidService.createKid(this.$store.state.user.id, this.newKid).then(

      )
    }
  }
}

</script>

<style>

</style>