<template>
  <div class="container">
    <div class="mascot-grid">
      <img v-for="mascot in allMascots"
        :key="mascot.id"
        :src="mascot.url"
        :class="{ selected: mascot === selectedMascot }"
        @click="selectMascot(mascot)"
        />
    </div>
    <button id="equip-mascot-btn" @click="equipMascot(selectedMascot)">Equip Selected Mascot</button>
  </div>
</template>

<script>
import MascotSelectionService from '../services/MascotSelectionService';
export default {
  name: "mascot-selector",
  data() {
    return {
      selectedMascot: null,
    };
  },
  methods: {
    selectMascot(mascot) { 
      this.selectedMascot = mascot;
    },
    equipMascot(mascot) {
      this.$store.commit("EQUIP_MASCOT", mascot);
    }
  },
  computed: {
    allMascots() {
      return this.$store.state.mascots;
    },
  },
    created() {    
      // set the selectedMascot to the ID of the initially equipped mascot
      this.selectedMascot = this.$store.state.equippedMascot.id;
      MascotSelectionService.getAllMascotSelector();
  },
};
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  border: 10px solid var(--primary800);
  background-color: var(--primary400);
  border-radius: 0.5rem;
  padding: 1rem;
}
.mascot-grid {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
  background-color: var(--primary400);
}
.mascot-grid img {
  flex: 0 1 calc(25% - 1rem);
  max-width: calc(25% - 1rem);
  width: 100%;
  border: 5px solid var(--primary800);
  margin-bottom: 1rem;
  border-radius: 0.5rem;
  cursor: pointer;
}
.mascot-grid .selected {
  border: 5px inset yellow;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
}
#equip-mascot-btn {
  border: 5px solid var(--primary800);
  cursor: pointer;
}
  button {
    border-radius: 0.25rem;
    background-color: var(--primary400);
    border: 2px solid;
    border-color: #1dc5ba;
    padding: 10px 20px;
    font-size: 1.5rem;
    color: var(--primary800);
    border: 3px solid var(--primary800);
    font-weight: bold;
    transition-duration: 0.4s;
  }
  button:hover {
    background-color: var(--primary800);
    border: 3px solid var(--primary400);
    color: white;
  }
</style>
