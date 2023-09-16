// thêm/ sửa/ xóa khóa học với fetch và rest API
var coursesApi = "http://localhost:3000/courses";
function start() {
  getCourses(renderCourses);
  handleCreateForm();
}
start();
// Functions
function getCourses(callback) {
  fetch(coursesApi)
    .then(function (response) {
      return response.json();
    })
    .then(callback);
}
function createCourses(data, callback) {
  var options = {
    method: "POST",
    body: JSON.stringify(data),
  };
  fetch(coursesApi, options)
    .then(function (response) {
      return response.json();
    })
    .then(callback);
}
function renderCourses(courses) {
  var listCoursesBlock = document.querySelector("#list-courses");
  var htmls = courses.map(function (course) {
    return `<li>
    <h4>${course.name}</h4>
    <p>${course.description}</p>
    </li>`;
  });
  listCoursesBlock.innerHTML = htmls.join("");
}
function handleCreateForm() {
  var createBtn = document.querySelector("#create");
  createBtn.onclick = function () {
    var name = document.querySelector('input[name="name"]').value;
    var description = document.querySelector(
      'input[description="description"]'
    ).value;
    var formData = {
      name: name,
      description: description,
    };
    createCourses(formData);
  };
}
