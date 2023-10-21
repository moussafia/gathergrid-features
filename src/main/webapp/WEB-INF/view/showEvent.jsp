<%--
  Created by IntelliJ IDEA.
  User: YouCode
  Date: 19/10/2023
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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


<div id="modal" tabindex="-1" class="fixed top-1/2 left-1/2 right-0 z-50 hidden w-full p-4 overflow-x-hidden overflow-y-auto md:inset-0 h-[calc(100%-1rem)] max-h-full">
  <div class="relative w-full max-w-4xl max-h-full">
    <!-- Modal content -->
    <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
      <!-- Modal header -->
      <div class="flex items-center justify-between p-5 border-b rounded-t dark:border-gray-600">
        <h3 class="text-xl font-medium text-gray-900 dark:text-white">
          Large modal
        </h3>
        <button type="button" class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 ml-auto inline-flex justify-center items-center dark:hover:bg-gray-600 dark:hover:text-white" data-modal-hide="modal">
          <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 14">
            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6"/>
          </svg>
          <span class="sr-only">Close modal</span>
        </button>
      </div>
      <!-- Modal body -->
      <form action="" method="post" >
      <div class="p-6 space-y-6">
        <p class="text-base leading-relaxed text-gray-500 dark:text-gray-400">
          With less than a month to go before the European Union enacts new consumer privacy laws for its citizens, companies around the world are updating their terms of service agreements to comply.
        </p>
        <p class="text-base leading-relaxed text-gray-500 dark:text-gray-400">
          The European Union’s General Data Protection Regulation (G.D.P.R.) goes into effect on May 25 and is meant to ensure a common set of data rights in the European Union. It requires organizations to notify users as soon as possible of high-risk data breaches that could personally affect them.
        </p>
      </div>
      <!-- Modal footer -->
      <div class="flex items-center p-6 space-x-2 border-t border-gray-200 rounded-b dark:border-gray-600">
        <button type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Booking</button>
        <button data-modal-hide="modal" type="button" class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-gray-200 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10 dark:bg-gray-700 dark:text-gray-300 dark:border-gray-500 dark:hover:text-white dark:hover:bg-gray-600 dark:focus:ring-gray-600">Decline</button>
      </div>
      </form>
    </div>
  </div>
</div>

<script>
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

