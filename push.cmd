set commitmsg=%~1%
git add -A
git commit -a -m "%commitmsg%"
git push origin master
