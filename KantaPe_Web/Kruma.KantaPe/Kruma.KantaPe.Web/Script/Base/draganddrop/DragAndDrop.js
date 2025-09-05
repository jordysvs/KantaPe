$(function () {
    $(".drag").draggable({
        opacity: 0.7, cursor: "move", scroll: true, scrollSensitivity: 100,
        start: function (e, ui) {
            $(ui.helper).addClass("ui-draggable-helper");
        },
        revert: "invalid"
    });
    $(".drop").droppable({
        accept: ".drag",
        activeClass: "ui-state-hover",
        hoverClass: "ui-state-active",
        drop: function (event, ui) {
        }
    });
});
