<template>
  <div class="container">
    <div class="button-container">
      <router-link v-bind:to="{ name: 'games' }">
        <button>Play Games</button>
      </router-link>
      <router-link v-bind:to="{ name: 'closet' }">
        <button>Your Closet</button>
      </router-link>
    </div>
    <div class="content-layout">
      <mascot-selector id="mascot-selector-container" />
      <store-block id="store-block-container" />
    </div>
  </div>
</template>

<script>
import StoreBlock from "../components/StoreBlock.vue";
import MascotSelector from "../components/MascotSelector.vue"

export default {
    name: "store-view",
    components: {
        StoreBlock,
        MascotSelector,
    },
    methods: {

    }
}
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
}
.button-container {
  display: flex;
  gap: 2rem;
  margin-bottom: 1rem;
  margin-left: auto;
  margin-top: 1rem;
  cursor: pointer;
}
.content-layout {
    display: flex;
    align-items: flex-start;
}
#mascot-selector-container {
  flex-direction: row;
  height: 100%;
  width: 50%;
  margin-right: 1.5rem;
}
#store-block-container {
  width: 50%;
  margin-left: 1.5rem;
}
</style>
