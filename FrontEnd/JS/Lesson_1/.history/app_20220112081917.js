// let a = [42, 23, 74, 11, 65, 58, 94, 36, 99, 87];
// console.log(a.sort());

let mangViDu = [42, 23, 74, 11, 65, 58, 94, 36, 99, 87];
// Sắp xếp với hàm so sánh và sort()
mangViDu.sort(function (a, b) {
  if (a < b) return 1;
  if (a > b) return -1;
  return 0;
});
// In ra kết quả
console.log(mangViDu);
