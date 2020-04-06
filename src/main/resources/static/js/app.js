const employeeFormSubmitBtnEle = document.getElementById('btnSubmit');
const employeeForm = document.querySelector('form');

const employeeFormDeleteBtns = document.querySelectorAll('.btn-danger');

if (employeeFormSubmitBtnEle) {
    employeeFormSubmitBtnEle.addEventListener('click', evt => {
        evt.preventDefault();
        employeeFormSubmitBtnEle.disabled = true;
        employeeFormSubmitBtnEle.innerText = "Saving...";

        let validInput = false;

        const formAllEles = employeeForm.elements;
        for (let i = 0, l = formAllEles.length; i < l; ++i) {
            formAllEles[i].readOnly = true;
        }

        setTimeout(() => {

            const allInputTextEles = document.querySelectorAll('input');
            const allInputTextList = [...allInputTextEles];

            validInput = allInputTextList.every(ele => ele.value.trim() !== '');

            if (validInput) {
                employeeForm.submit();
            } else {
                employeeFormSubmitBtnEle.disabled = false;
                employeeFormSubmitBtnEle.innerText = "Saving";
                for (let i = 0, l = formAllEles.length; i < l; ++i) {
                    formAllEles[i].readOnly = false;
                }
                document.getElementById('errMsg').innerHTML = "<p>Please check your input!</p>";
            }

        }, 3000);
    });
}

[...employeeFormDeleteBtns].forEach(deleteBtnEle => {
    deleteBtnEle.addEventListener('click', evt => {
        evt.preventDefault();

        if (confirm('Are you sure you want to delete this employee?')) {
            window.location.href = `${deleteBtnEle.getAttribute('href')}`;
        }
    })
})
