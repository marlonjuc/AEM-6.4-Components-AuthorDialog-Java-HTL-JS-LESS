var MultiColumn = function ($component) {
    this.$component = $component;
};

MultiColumn.prototype = function () {

    //Public function
    var _init = function () {

        bindEvents(this.$component);

        return this;
    };

    // Private members
    var bindEvents = function ($component) {

        var wrapper = $component.children(".multiColumnWrapper");
        var grid = wrapper.children(".aem-Grid");
        var topCenterContainer = wrapper.find(".top-center-section");
        if (topCenterContainer.length) {
            var otherParsysContainers = grid.find(".parsys-container");
            var otherParsysContainersNoPadding = grid.find(".parsys-container-no-padding");

            resizeOtherParsysContainers(wrapper, topCenterContainer, otherParsysContainers, otherParsysContainersNoPadding);
            $( window ).resize(function () {
                resizeOtherParsysContainers(wrapper, topCenterContainer, otherParsysContainers, otherParsysContainersNoPadding);
            });
        }

        return this;
    };

    var resizeOtherParsysContainers = function ($grid, $topCenterContainer, $otherParsysContainers, $otherParsysContainersNoPadding) {
        if ($( window ).width() > 768) {
            $otherParsysContainers.css("margin-top", $topCenterContainer.innerHeight() + "px");
            $otherParsysContainersNoPadding.css("margin-top", "");
        }

        if ($( window ).width() > 1200) {
            $otherParsysContainersNoPadding.css("margin-top", $topCenterContainer.innerHeight() + "px");
        }

        if ($( window ).width() < 768) {
            $otherParsysContainers.css("margin-top", "");
        }

        return this;
    };

    // Return members to make public
    return {
        init: _init
    };

}();

$(document).ready(function() {
    $(".multi-column").each(function(){
        new MultiColumn($(this)).init();
    });
});
