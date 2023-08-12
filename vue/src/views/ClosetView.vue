<template>
  <div class="container">
    <div class="button-container">
      <!-- <button>Select Avatar</button> -->
      <router-link v-bind:to="{ name: 'games' }">
        <button>Play Games</button>
      </router-link> 
      <router-link v-bind:to="{ name: 'item-store' }">
        <button>Visit The Shop</button>
      </router-link>
    </div>
    <div class="content-layout">
      <mascot-block id="mascot-block-container" />
      <closet-block id="closet-block-container" />
    </div>
  </div>
</template>

<script>
// import KidsService from "../services/KidService.js";
// import MascotService from "../services/MascotService.js";
// import ClosetService from "../services/ClosetService.js";
import MascotBlock from "../components/MascotBlock.vue";
import ClosetBlock from "../components/ClosetBlock.vue";

export default {
    name: "closet-view",
    components: {
        MascotBlock,
        ClosetBlock,
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
}
.content-layout {
    display: flex;
    align-items: flex-start;
}
#mascot-block-container {
  flex-direction: row;
  height: 100%;
  width: 50%;
}
#closet-block-container {
  width: 50%;
}
</style>