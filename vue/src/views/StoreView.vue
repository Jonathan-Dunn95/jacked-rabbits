<template>
  <div class="container">
    <div class="button-container">
      <!-- <router-link v-bind:to="{ name: 'games' }">
        <button>Play Games</button>
      </router-link> --> 
      <router-link v-bind:to="{ name: 'closet' }">
        <button>Your Closet</button>
      </router-link>
    </div>
    <div class="content-layout">
      <mascot-block />
      <store-block />
    </div>
  </div>
</template>

<script>
import MascotBlock from "../components/MascotBlock.vue";
import StoreBlock from "../components/StoreBlock.vue";

export default {
    name: "closet-view",
    components: {
        MascotBlock,
        StoreBlock,
    },
    methods: {

    }
}
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.button-container {
  display: flex;
  gap: 2rem;
  margin-bottom: 1rem;
  margin-left: auto;
  margin-top: 1rem;
}
.content-layout {
    display: flex;
    align-items: center;
    justify-content: space-evenly;
}
</style>
