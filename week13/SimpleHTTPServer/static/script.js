const push = document.getElementById("push");
push.addEventListener("click", handleClick);

function handleClick() {
  const bg = document.getElementById("bg");
  const penguin = document.getElementById("penguin");
  const message = document.getElementById("message");

  push.style.display = "none";
  bg.style.display = "block";
  penguin.style.display = "block";
  message.style.display = "block";
  document.body.style.backgroundColor = "#ffee33";
}
