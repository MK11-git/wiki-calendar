
function test(){
  var a = document.documentElement;
  var y = a.scrollHeight - a.clientHeight;
  window.scroll({
        top: y,
        behavior: "smooth"
    });
}