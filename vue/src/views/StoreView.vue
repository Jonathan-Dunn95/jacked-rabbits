<template>
  <div class="container">
    <div class="kid-info-div">
      <kid-info id="kid-info-container" />
    </div>
    <div class="content-layout">
      <mascot-selector id="mascot-selector-container" />
      <div id="store-area">
      <!-- <kid-info id="kid-info-container" /> -->
      <store-block id="store-block-container" />
      </div>
    </div>
  </div>
</template>

<script>
import StoreBlock from "../components/StoreBlock.vue";
import MascotSelector from "../components/MascotSelector.vue"
import KidInfo from '../components/Kidinfo.vue';

export default {
    name: "store-view",
    components: {
        StoreBlock,
        MascotSelector,
        KidInfo
    },
    methods: {

    }
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
    align-items: flex-start;
}
#mascot-selector-container {
  height: 100%;
  width: 50%;
  margin-right: 1.5rem;
}
#store-block-container {
  width: 90%;
  margin-left: 1.5rem;
}
#store-area {
  display: flex;
  flex-direction: column;
  width: 50%
}
.kid-info-div {
  justify-content: flex-end;
  margin-left: 53%;
  margin-right: 1.5%;
}
</style>
