<template>
  <div class="container">
    <img v-for="mascot in allMascots"
      :key="mascot.id"
      :src="mascot.url"
      :class="{ selected: mascot.id === selectedMascot }"
      @click="selectMascot(mascot)"
      @dblclick="equipMascot(mascot)"
      />
  </div>
</template>

<script>
export default {
  name: "mascot-selector",
  data() {
    return {
      selectedMascot: null,
    };
  },
  methods: {
    selectMascot(mascot) { 
      this.selectedMascot = mascot.id;
    },
    equipMascot(mascot) {
      this.$store.commit("EQUIP_MASCOT", mascot);
    }
  },
  computed: {
    allMascots() {
      return this.$store.state.mascots;
    }
  },
  created() {    
    // set the selectedMascot to the ID of the initially equipped mascot
    this.selectedMascot = this.$store.state.equippedMascot[0].id;
  }
};
</script>

<style scoped>
.container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  border: 10px solid var(--primary800);
  background-color: var(--primary400);
  border-radius: 0.5rem;
  padding: 1rem;
}
img {
  flex: 0 1 calc(25% - 1rem);
  max-width: calc(25% - 1rem);
  width: 100%;
  border: 5px solid var(--primary800);
  margin-bottom: 1rem;
  border-radius: 0.5rem;
  cursor: pointer;
}
.selected {
  border: 5px inset yellow;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
}
</style>
