<template>
  <div id="equipment-container">
      <img class="equipment-item" src="https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat1.jpg" alt="hat1" />
      <img class="equipment-item" src="https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt4.jpg" alt="hat1" />
      <img class="equipment-item" src="https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes4.jpg" alt="hat1" />
      <img class="equipment-item" src="https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc12.jpg" alt="hat1" />
      <img class="equipment-item" src="https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back6.jpg" alt="hat1" />
  </div>
</template>

<script>
export default {
    named: "equipment-block"
}
</script>

<style scoped>
#equipment-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    border: 10px solid var(--primary800);
    background-color: var(--primary400);
    border-radius: 0.5rem;
}
#equipment-container > img {
    height: 10rem;
    width: 10rem;
    border: 10px ridge yellow;
    border-radius: 0.5rem;
}
</style>