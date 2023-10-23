
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js" defer></script>
    <title>Show Event </title>
</head>
<body class="h-screen overflow-hidden flex items-center justify-center" style="background: #edf2f7;">

<c:if test="${not empty message}">
    ${message}
</c:if>
<div class="mx-auto bg-gray-700 h-screen flex items-center justify-center px-8">
    <div class="flex flex-col w-full bg-white rounded shadow-lg sm:w-3/4 md:w-1/2 lg:w-3/5">
        <div class="w-full h-64 bg-top bg-cover rounded-t" style="background-image: url(https://www.si.com/.image/t_share/MTY4MTkyMjczODM4OTc0ODQ5/cfp-trophy-deitschjpg.jpg)"></div>
        <div class="flex flex-col w-full md:flex-row">
            <div class="flex flex-row justify-around p-4 font-bold leading-none text-gray-800 uppercase bg-gray-400 rounded md:flex-col md:items-center md:justify-center md:w-1/4">
                <div class="md:text-3xl">Jan</div>
                <div class="md:text-6xl">13</div>
                <div class="md:text-xl">7 pm</div>
            </div>
            <div class="p-4 font-normal text-gray-800 md:w-3/4">
                <h1 class="mb-4 text-4xl font-bold leading-none tracking-tight text-gray-800">2020 National Championship</h1>
                <p class="leading-normal">The College Football Playoff (CFP) determines the national champion of the top division of college football. The format fits within the academic calendar and preserves the sport’s unique and compelling regular season.</p>
                <div class="flex flex-row items-center mt-4 text-gray-700">
                    <div class="w-1/2">
                        Mercedes-Benz Superdome
                    </div>
                    <button data-modal-target="modal" data-modal-toggle="modal" class="block w-full md:w-auto text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800" type="button">
                        Large modal
                    </button>
                    <div class="w-1/2 flex justify-end">
                        <img src="https://collegefootballplayoff.com/images/section_logo.png" alt="" class="w-8">
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>


<div id="modal" tabindex="-1" class="fixed top-1/2 left-1/2 right-0 z-50 hidden w-full p-4 overflow-x-hidden overflow-y-auto md:inset-0 h-[calc(80%-1rem)] max-h-full">
    <div class="relative w-full max-w-4xl max-h-full">
        <!-- Modal content -->
        <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
            <!-- Modal header -->
            <div class="flex items-center justify-between p-5 border-b rounded-t dark:border-gray-600">
                <h3 class="text-xl font-medium text-gray-900 dark:text-white">
                    Bocking Ticket
                </h3>
                <button type="button" class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 ml-auto inline-flex justify-center items-center dark:hover:bg-gray-600 dark:hover:text-white" data-modal-hide="modal">
                    <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 14">
                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6"/>
                    </svg>
                    <span class="sr-only">Close modal</span>
                </button>
            </div>
            <!-- Modal body -->
            <form action="${pageContext.request.contextPath}/reservation" id="containerForm-add" onsubmit="return validateForm(this);">
                <div class="p-6 espace-y-4 b-0 border-b-2 py-2 flex justify-between items-center">
                    <h2 class="text-xl font-semibold text-gray-900 dark:text-white">
                        Choix your ticket</h2>
                </div>
                <div id="show_item">
                    <div class="p-4 flex relative items-center mx-auto px-8 shadow-md pb-2 pt-2 append_item">
                        <div class="mx-1">
                            <%--@declare id="quantity"--%><label for="quantity"
                                                                 class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Number of ticket
                            </label>
                            <input type="number" name="Standard"
                                   class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                                   >
                        </div>
                        <div class="mx-1">
                            <%--@declare id="type"--%>
                            <label for="type" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Ticket Type</label>
                            <div class="radio-type-ticket">
                                <input type="radio" id="standard" name="radio1" class="mr-2" checked />
                                <label for="standard" class="mr-4">Standard</label>
                            </div>
                        </div>

                    </div>
                    <div class="p-4 flex relative  items-center mx-auto px-8 shadow-md pb-2 pt-2 append_item">
                        <div class="mx-1">
                            <%--@declare id="quantity"--%><label for="quantity"
                                                                 class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Number of ticket
                        </label>
                            <input type="number" name="vip"
                                   class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                                   >
                        </div>
                        <div class="mx-1">
                            <%--@declare id="type"--%>
                            <label for="type" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Ticket Type</label>
                            <div class="radio-type-ticket">
                                <input type="radio" id="vip" name="radio2"  class="mr-2" checked />
                                <label for="vip">VIP</label>
                            </div>
                        </div>
                    </div>
                    <!--- child here -->
                </div>

                <!-- Modal footer -->
                <div class="flex items-center p-6 space-x-2 border-t border-gray-200 rounded-b dark:border-gray-600">
                    <button type="submit"
                            class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Create</button>
                    <button data-modal-hide="modalAddEvent" type="button"
                            class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-blue-300 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10 dark:bg-gray-700 dark:text-gray-300 dark:border-gray-500 dark:hover:text-white dark:hover:bg-gray-600 dark:focus:ring-gray-600">Decline</button>
                </div>
            </form>

        </div>
    </div>
</div>

<script>

    function validateForm(form) {
        const numberInputs = form.querySelectorAll('input[type="number"]');

        if((numberInputs[0].value===''|| isNaN(numberInputs[0].value ))&& (numberInputs[1].value===''|| isNaN(numberInputs[1].value))){
                alert('Please fill in all number fields with valid numbers.');
                return false;
        }
        return true;
    }


    document.addEventListener("DOMContentLoaded", function () {
        const modalButton = document.querySelector('[data-modal-toggle="modal"]');
        const modal = document.getElementById('modal');
        const closeModalButton = modal.querySelector('[data-modal-hide="modal"]');

        modalButton.addEventListener('click', function () {
            modal.classList.remove('hidden');
            document.body.classList.add('overflow-hidden');
        });

        closeModalButton.addEventListener('click', function () {
            modal.classList.add('hidden');
            document.body.classList.remove('overflow-hidden');
        });
    });
</script>


</body>
</html>

