res=(curl -X POST http://localhost:8080/upload \
  -F "file=@dummy.pdf")

if [ $? -eq 0 ]; then
    echo 1
else
    echo 0
fi


