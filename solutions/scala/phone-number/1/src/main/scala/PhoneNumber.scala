object PhoneNumber {

  def clean(rawNumber: String): Option[String] = {

    val onlyNumbers = rawNumber.filter(_.isDigit)
    val areaCode = onlyNumbers.head
    val exchangeCode = onlyNumbers(3)

    if (exchangeCode == '0' || exchangeCode == '1') None
      else (onlyNumbers.length, areaCode) match
        case (10, '0') => None
        case (10, '1') => None
        case (10, _) => Some(onlyNumbers)
        case (11, '1') => Some(onlyNumbers.tail)
        case (_,_)   => None
    }
  }
