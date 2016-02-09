function usage {
   echo "usage: ./generate.sh <-o directory> <-p package> entity1 entity2 ..."
   exit
}

directory="."
package="net.bonvio"

while getopts "o:p:" opt; do
  case $opt in
    o) directory="$OPTARG";;
    p) package="$OPTARG";;
    \?) usage;;
  esac
done

shift $(($OPTIND - 1))
if [ $# -eq 0 ]
	then usage
fi

while [ "$1" != "" ]; do
  entity=$1
  ./generate.sh -c -o $directory/controller/implementations -p $package $entity
  echo " controller  implementations  $entity  generated"
  ./generate.sh -d -o $directory/dao/implementations -p $package $entity
  echo "    dao      implementations  $entity  generated"
  ./generate.sh -d -i -o $directory/dao/interfaces -p $package $entity
  echo "    dao        interfaces     $entity  generated"
  ./generate.sh -s -o $directory/service/implementations -p $package $entity
  echo "  service    implementations  $entity  generated"
  ./generate.sh -s -i -o $directory/service/interfaces -p $package $entity
  echo "  service      interfaces     $entity  generated"
  shift
done

