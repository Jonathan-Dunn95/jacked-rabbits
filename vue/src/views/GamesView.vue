<template>
  <div class="container">
      <h1>Play Games Landing Page</h1>
      <router-link v-bind:to="{ name: 'item-store' }">
        <button>Visit The Shop</button>
      </router-link>
      <router-link v-bind:to="{ name: 'closet' }">
        <button>Your Closet</button>
      </router-link>
  </div>
</template>

<script>

export default {
    name: "games",
    components: {
    },
    methods: {

    },

}
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
</style>