<template>
  <div class="container">
  <div class="kid-info-div">
    <kid-info id="kid-info-container" />
  </div>
    <div class="content-layout">
      <mascot-block id="mascot-block-container" />
      <equipment-block id="equipment-block-container" />
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
import EquipmentBlock from "../components/EquipmentBlock.vue";
import KidInfo from "../components/Kidinfo.vue";

export default {
    name: "closet-view",
    components: {
        MascotBlock,
        ClosetBlock,
        EquipmentBlock,
        KidInfo
    },
}
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  margin-top: 1rem;
}
.button-container {
  display: flex;
  gap: 2rem;
  margin-bottom: 1rem;
  margin-left: auto;
  margin-top: 1rem;
}
button { 
  cursor: pointer;
}
.content-layout {
  display: flex;
  justify-content: space-evenly;
  width: 100%;
}
#mascot-block-container {
  height: 100%;
  width: 40%
  /* margin-right: 1.5rem; */
}
#equipment-block-container {
  height: 100%;
  width: 10%;
  margin-left: 1.5rem;
  margin-right: 1.5rem;
}
#closet-block-container {
  width: 40%;
}
#kid-info-container {
  display: flex;
}
.kid-info-div {
  justify-content: flex-end;
  margin-left: 57%;
  margin-right: 1.3%;
}
</style>