<template>
  <div class="class-list">
    <h2>Class List</h2>
    <ul>
      <li v-for="classItem in classes" :key="classItem.id">
        <h3>{{ classItem.className }}</h3>
        <p>Teacher: {{ classItem.teacher }}</p>
        <!-- Other class details to display -->
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      classes: [
        {
          id: 1,
          className: 'Class A',
          teacher: 'Teacher X'
          // Other class details
        },
        {
          id: 2,
          className: 'Class B',
          teacher: 'Teacher Y'
          // Other class details
        },
        // Other classes
      ]
    };
  }
  // Methods or lifecycle hooks if needed
};
</script>

<style>
@import 'assets/css/styles.css';
.class-list {
}
</style>
