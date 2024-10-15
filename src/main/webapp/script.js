document.addEventListener("DOMContentLoaded", function () {
    const nextButtons = document.querySelectorAll(".next-btn");
    const amountInput = document.getElementById("montant");
    const amountValue = document.getElementById("amount-value");
    const durationInput = document.getElementById("duree");
    const durationValue = document.getElementById("duration-value");
    const monthlyInput = document.getElementById("monsualite");
    const monthlyValue = document.getElementById("monthly-value");

    let currentStep = 1;
    const interestRate = 0.04;

    function calculateMonthlyPayment(amount, duration) {
        const monthlyRate = interestRate / 12;
        return Math.round((amount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -duration)));
    }

    function calculateLoanAmount(monthly, duration) {
        const monthlyRate = interestRate / 12;
        return Math.round((monthly * (1 - Math.pow(1 + monthlyRate, -duration))) / monthlyRate);
    }

    function updateMonthly() {
        const amount = parseInt(amountInput.value);
        const duration = parseInt(durationInput.value);
        const monthly = calculateMonthlyPayment(amount, duration);
        monthlyInput.value = monthly;
        monthlyValue.textContent = monthly;
    }

    function updateAmount() {
        const monthly = parseInt(monthlyInput.value);
        const duration = parseInt(durationInput.value);
        const amount = calculateLoanAmount(monthly, duration);
        amountInput.value = amount;
        amountValue.textContent = amount;
    }


    amountInput.addEventListener("input", function () {
        amountValue.textContent = amountInput.value;
        updateMonthly();
    });

    durationInput.addEventListener("input", function () {
        durationValue.textContent = durationInput.value;
        updateMonthly();
    });

    monthlyInput.addEventListener("input", function () {
        monthlyValue.textContent = monthlyInput.value;
        updateAmount();
    });



});