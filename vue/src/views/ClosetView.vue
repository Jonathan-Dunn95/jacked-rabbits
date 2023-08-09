<template>
  <div class="container">
      <h1>Kid's Closet Page</h1>
      <h4>View Mascot and Closet from here</h4>
      <mascot-block />
      <closet-block />
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
  justify-content: center;
}
</style>