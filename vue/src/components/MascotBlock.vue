<template>
  <div class="container">
    <img :src="equippedMascotUrl" />
  </div>
</template>

<script>
import mascotSelectionService from '../services/MascotSelectionService';
import mascotService from '../services/MascotService';

export default {
  data() {
    return {
      selectedMascot: null,
    };
  },
  computed: {
    equippedMascotUrl() {
      return this.$store.state.equippedMascot.imgURL;
    }
  },
  methods: {
    onMascotSelected() {
      this.$emit('mascotSelected', this.selectedMascot);
    }
  },
  created() {
    // console.log(this.$store.state.user.id)
    mascotService.getMascotByKidId(this.$store.state.user.id).then( response => {
      // console.log(response.data.mascotId)
      // this.$store.state.equippedMascot.id = response.data.mascotId;
      this.$store.commit('SET_MASCOT_ID', response.data.mascotSelectionId)
      mascotSelectionService.getMascotSelectionByMascotId(this.$store.state.equippedMascot.mascotSelectionId).then( response2 => {
      this.$store.commit('SET_SELECTED_MASCOT', response2.data)
    })
    })
  }
}
</script>

<style scoped>
.container {
  display: flex;
  /* align-items: center; */
  justify-content: center;
  width: 100%;
}
img { 
  flex: 0 1 calc(25% - 1rem);
  border: 10px solid var(--primary800);
  border-radius: 0.25rem;
  /* max-width: 90000px */
}
</style>