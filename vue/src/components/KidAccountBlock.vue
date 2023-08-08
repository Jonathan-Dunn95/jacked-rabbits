<template>
  <div>
      <div class="kid-block">
        <h2>{{ kid.name }}</h2>
        <p>Steps: {{ kid.steps }}</p>
        <p>Hours of Activity: {{ kid.hours }}</p>
        <button>Log Hours/Steps</button>
        <button>View Account</button>
        <button>Remove Kid</button>
        <button v-on:click="addKid">add kids</button>
        <ul>
          <!-- Loop through kids in DB -->
          <li>
              <h2>child_name</h2>
          </li>
        </ul>
      </div>
  </div>
</template>

<script>
export default {
  
}

</script>

<style>

</style>