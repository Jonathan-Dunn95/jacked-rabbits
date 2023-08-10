<template>
  <div class="container">
    <div class="button-container">
      <!-- <router-link v-bind:to="{ name: 'games' }">
        <button>Play Games</button>
      </router-link> --> 
      <router-link v-bind:to="{ name: 'item-store' }">
        <button>Visit The Shop</button>
      </router-link>
    </div>
    <div class="content-layout">
      <mascot-block class="content-block" />
      <closet-block class="content-block" />
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
    flex-grow: 1;
}
.content-block {
  flex: 1;
  height: 50%;
  width: 50%;
}
</style>