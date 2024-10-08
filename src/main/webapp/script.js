let currentTab = 0;

function showTab(n) {
    let tabs = document.querySelectorAll(".tab");
    tabs[n].style.display = "block";
}

function nextStep() {
    let tabs = document.querySelectorAll(".tab");
    tabs[currentTab].style.display = "none";
    currentTab++;
    if (currentTab >= tabs.length) {
        document.getElementById("creditForm").submit();
    } else {
        showTab(currentTab);
    }
}
