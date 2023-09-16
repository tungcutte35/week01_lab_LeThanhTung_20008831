// thêm/ sửa/ xóa khóa học với fetch và rest API
var coursesApi = "http://localhost:3000/courses";
function start() {
  getCourses(renderCourses);
}
start();

// Functions
function getCourses() {
  fetch(coursesApi)
    .then(function (response) {
      return response.json();
    })
    .then(callback);
}
function renderCourses() {
  var listCoursesBlock = document.querySelector("#list-courses");
  var html = courses.map(function (course) {
    return `<li>
    <h4>${courses.name}</h4>
    <p>${courses.description}</p>
    </li>`;
  });
  listCoursesBlock.innerHTML = htmls.join("");
}
