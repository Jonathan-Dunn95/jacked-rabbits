<template>
  <div>
<<<<<<< HEAD:vue/src/views/ClosetView.vue
=======
      <h1>Manage Kids</h1>
      <button v-on:click="addKid">add kids</button>
      <ul>
          <!-- Loop through kids in DB -->
          <li>
              <h2>child_name</h2>
          </li>
      </ul>
>>>>>>> 06442166092cc7888c9af71aa6930c773fea0b1c:vue/src/views/ManageKids.vue
  </div>
</template>

<script>
export default {
    name: "manage-kids",
    methods: {
        addKid() {
            console.log("adding kid")
        }
    }
}
</script>

<style>

</style>