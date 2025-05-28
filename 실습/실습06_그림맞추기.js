const img = document.querySelectorAll("#imgBox img");
const click = document.querySelector("#click");
const reset = document.querySelector("#reset");
const ifWin = document.querySelector("#ifWin");

imgSrcList = [];
for (const i of img) {
  imgSrcList.push(i.getAttribute("src"));
}
let count = 0;
click.addEventListener("click", (e) => {
  count++;
  click.textContent = `Click ${count}`;
  const randomIdxList = [];
  for (let i = 0; i < img.length; i++) {
    const rNum = Math.floor(Math.random() * 3);
    randomIdxList.push(rNum);
    img[i].setAttribute("src", imgSrcList[rNum]);
  }
  if (
    randomIdxList[0] === randomIdxList[1] &&
    randomIdxList[1] === randomIdxList[2]
  ) {
    ifWin.textContent = "승리하셨습니다.";
    click.setAttribute("disabled", "true");
  }
});

reset.addEventListener("click", (e) => {
  count = 0;
  click.textContent = `Click`;
  click.removeAttribute("disabled");
  ifWin.textContent = "";
  for (let i = 0; i < img.length; i++) {
    img[i].setAttribute("src", imgSrcList[i]);
  }
});
