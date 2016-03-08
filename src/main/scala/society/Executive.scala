package society

package professional {
  class Executive {
    private[professional] var workDetails = null
    private[society] var friends = null
    private[this] var secrets = null



    def help(another: Executive): Unit = {
      println(another.workDetails)
      //println(another.secrets)
    }
  }


}


