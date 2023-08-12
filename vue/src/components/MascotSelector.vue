<template>
  <div class="container">
    <img v-for="(avatar, index) in avatars"
      :key="index"
      :src="avatar.url"
      :class="{ selected: index === selectedIndex }"
      @click="selectAvatar(index)"
    />
  </div>
</template>

<script>
export default {
  name: "mascot-selector",
  data() {
    return {
      avatars: [
        { url: "https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot1.jpg" },
        { url: "https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot2.jpg" },
        { url: "https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot3.jpg" },
        { url: "https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot4.jpg" },
        { url: "https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot5.jpg" },
        { url: "https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot6.jpg" },
        { url: "https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot7.jpg" },
        { url: "https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot8.jpg" },
        { url: "https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot9.jpg" },
        { url: "https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot10.jpg" },
        { url: "https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot11.jpg" },
        { url: "https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot12.jpg" },
      ],
      selectedIndex: null,
    };
  },
  methods: { 
    selectAvatar(index) { 
      this.selectedIndex = index;
    }
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
  border: 4px solid var(--primary800);
  margin-bottom: 1rem;
  border-radius: 0.5rem;
  cursor: pointer;
}
.selected {
  border: 5px inset var(--primary600);
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
}
</style>
