var LessAutoprefix = require('less-plugin-autoprefix');
var autoprefix = new LessAutoprefix({ browsers: ['last 2 versions'] });
var gulp = require('gulp');
var less = require('gulp-less')


gulp.task('less', function () {
    return gulp.src('src/main/resources/static/_ui-src/less/style.less')
        .pipe(less({
            plugins: [autoprefix]
          }))
        .pipe(gulp.dest('src/main/resources/static/css'))
});

gulp.task('auto', function () {
    return gulp.watch('src/main/resources/static/_ui-src/less/**.less', gulp.series('less'));
})


gulp.task('default', gulp.series('less','auto'));