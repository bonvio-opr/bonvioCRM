function usage {
   echo "usage: ./generate.sh [-p package <package>] [-i <interface>] [-c <controller>] [-d <dao>] [-s <service>] [-o directory <output directory>] Entity_name"
   exit
}

interface="class"
impl="Impl"
implcc="Impl"
request=""
package="implementations";
imports=""
pack=""
directory="."

while getopts "icsdo:p:" opt; do
  case $opt in
    \?) usage;;
    i) interface="interface";
       package="interfaces";
       impl="";
       implcc="";;
    c) what="Controller";
       typ="Controller";
       low="controller";;
    d) what="DAO";
       typ="Repository";
       low="dao";;
    s) what="Service";
       typ="Service";
       low="service";;
    p) pack=$OPTARG;;
    o) directory=$OPTARG;
       mkdir -p $directory;;
  esac
done

shift $(($OPTIND - 1))
if [ $# -eq 0 ]
    then usage
fi

entity=$1
annotation="@$typ"
if [[ $interface == "interface" ]]
then
    annotation=""
fi

if [[ $typ == "Controller" ]]
then
    request="@RequestMapping(\"/${entity,,}\")";
    imports="import org.springframework.web.bind.annotation.*;";
    implcc=""
fi

if [[ ($typ == "Service" || $typ == "Repository") && ($interface != "interface") ]]
then
    need="implements $entity$what"
    imports="import $pack.$low.interfaces.$entity$what;";
fi

echo -e "package $pack.$low.$package;

import $pack.$low.generic.$package.Generic$what$implcc;
import $pack.model.$entity;
import org.springframework.stereotype.$typ;
$imports

/**
 * Created by $USER on $(date +"%d.%m.%y").
 * Banana
*/

$annotation
$request
public $interface $entity$what$implcc extends Generic$what$implcc<$entity> $need {}" > $directory/$entity$what$implcc.java