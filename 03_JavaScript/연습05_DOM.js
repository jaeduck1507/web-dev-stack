// 1번 문제
function printText() {
  const result1 = document.querySelector("#result1");
  result1.innerHTML = "안녕하세요";
  // const p = document.createElement("p");
  // p.innerHTML = "안녕하세요";
  // result1.appendChild(p);
}

// 2번 문제
function printInputValue() {
  const input = document.querySelector("#customer");
  const result2 = document.querySelector("#result2");
  result2.textContent = input.value;
  input.value = "";
}

// 3번 문제
function changeColor() {
  const div = document.querySelector(".div-test");
  div.classList.add("active");
}

// 4번 문제
function stringLength() {
  const text = document.querySelector("#text");
  const result4 = document.querySelector("#result4");
  result4.textContent = text.value.length;
  text.value = "";
}

// 5번 문제
function stringSplit() {
  const la = document.querySelector("#la");
  const result5 = document.querySelector("#result5");
  const fruitList = la.textContent.split(", ");
  const ul = document.createElement("ul");
  result5.appendChild(ul);
  for (const i of fruitList) {
    console.log(i);
    const li = document.createElement("li");
    li.textContent = i;
    ul.appendChild(li);
  }
}

// 6번 문제
function arrayTest() {
  const preview = document.querySelector("#preview");
  const remove = document.querySelector("#remove");
  const add = document.querySelector("#add");
  const result6 = document.querySelector("#result6");

  const foodList = preview.textContent.split(" ");

  if (foodList.indexOf(remove.value) !== -1) {
    foodList.splice(foodList.indexOf(remove.value), 1);
  } // 음식 삭제
  if (add.value !== "") foodList.push(add.value); // 음식 추가

  preview.textContent = foodList.join(" ");
}

// 7번 문제
function addStudent() {
  const name = document.querySelectorAll(".name");
  const age = document.querySelectorAll(".age");
  const addr = document.querySelectorAll(".addr");

  for (let i = 0; i < 3; i++) {
    let inputName = prompt(`학생${i + 1}의 이름을 입력해주세요`);
    let inputAge = prompt(`학생${i + 1}의 나이을 입력해주세요`);
    let inputAddr = prompt(`학생${i + 1}의 주소을 입력해주세요`);
    name[i].textContent = inputName;
    age[i].textContent = inputAge;
    addr[i].textContent = inputAddr;
  }
}

// 8번
let count = 1;
function addItem() {
  const list = document.querySelector("#list");
  const li = document.createElement("li");
  li.textContent = `리스트 추가${count++}`;
  list.appendChild(li);
}
function removeItem() {
  const li = document.querySelector("#list li:last-child");
  if (li) {
    li.remove();
    count--;
  }
}

// 9번
function toggleClass() {
  const div = document.querySelector("#result9");
  div.classList.toggle("active");
}

// 10번
let sum = 0;
const cartList = [];
function addToCart() {
  const item = document.querySelector("#item");
  const price = document.querySelector("#price");
  const cart = document.querySelector("#cart");
  const total = document.querySelector("#total");
  const span = document.querySelector("#total span");

  if (!isNaN(Number(price.value)) && item.value !== "") {
    const li = document.createElement("li");
    li.textContent = `상품명 : ${item.value} - 가격 : ${price.value}원`;

    cart.appendChild(li);
    sum += Number(price.value);
    span.textContent = sum;
  } else alert("정확히 입력해주세요");
}
