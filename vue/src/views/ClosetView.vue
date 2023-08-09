<template>
  <div class="container">
      <h1>PLACEHOLDER Kid's Closet Page PLACEHOLDER</h1>
      <div class="content-layout">
      <mascot-block />
      <closet-block />
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
.content-layout {
    display: flex;
    align-items: center;
    justify-content: space-evenly;
}
</style>