set commitmsg=%~1%
git add -A
echo Done adding files
git commit -a -m "%commitmsg%"
echo Done
git push origin master
echo Done
