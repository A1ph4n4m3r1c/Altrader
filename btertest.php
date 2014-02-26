<?php
	
	
	$TESTPASS=$_GET['pass']; //URL user GET
	$PAIR=$_GET['pair'];
	$TYPE=$_GET['type'];
	$AMOUNT=$_GET['volume'];
	$FUNCTION=$_GET['function'];
	
	if($TESTPASS==REDACTED){

	function bter_query($path, array $req = array()) {
		// API settings, add your Key and Secret at here
		$key = REDACTED;
		$secret = REDACTED;
	 
			// generate a nonce to avoid problems with 32bits systems
		$mt = explode(' ', microtime());
		$req['nonce'] = $mt[1].substr($mt[0], 2, 6);
	 
		// generate the POST data string
		$post_data = http_build_query($req, '', '&');
		$sign = hash_hmac('sha512', $post_data, $secret);
	 
		// generate the extra headers
		$headers = array(
			'KEY: '.$key,
			'SIGN: '.$sign,
		);


		// curl handle (initialize if required)
		static $ch = null;
		if (is_null($ch)) {
			$ch = curl_init();
			curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
			curl_setopt($ch, CURLOPT_USERAGENT, 
				'Mozilla/4.0 (compatible; Bter PHP bot; '.php_uname('a').'; PHP/'.phpversion().')'
				);
		}
		curl_setopt($ch, CURLOPT_URL, 'https://bter.com/api/'.$path);
		curl_setopt($ch, CURLOPT_POSTFIELDS, $post_data);
		curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
		curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, FALSE);

		// run the query
		$res = curl_exec($ch);

		if ($res === false) throw new Exception('Curl error: '.curl_error($ch));
		//echo $res;
		$dec = json_decode($res, true);
		if (!$dec) throw new Exception('Invalid data: '.$res);
		return $dec;
	}
	 
	 function get_top_rate($pair, $type='BUY') {
		$rate = 0;

		// our curl handle (initialize if required)
		static $ch = null;
		if (is_null($ch)) {
			$ch = curl_init();
			curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
			curl_setopt($ch, CURLOPT_USERAGENT, 
				'Mozilla/4.0 (compatible; Bter PHP bot; '.php_uname('a').'; PHP/'.phpversion().')'
				);
		}
		curl_setopt($ch, CURLOPT_URL, 'https://bter.com/api/1/depth/'.$pair);
		curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, FALSE);

		// run the query
		$res = curl_exec($ch);
		if ($res === false) throw new Exception('Could not get reply: '.curl_error($ch));
		//echo $res;
		$dec = json_decode($res, true);
		if (!$dec) throw new Exception('Invalid data: '.$res);
		
		if (strtoupper($type) == 'BUY') {
			$r =  $dec['bids'][0];
			$rate = $r[0];
		} else  {
			$r = end($dec['asks']);
			$rate = $r[0];
		}

		return $rate;
	}


	try {
		// example 1: get funds
		//var_dump(bter_query('1/private/getfunds'));
		
		if($FUNCTION=="trade"){
		// place a buy order
		$pair = $PAIR;  // Sets pair
		$type = $TYPE; //buy or sell
		$rate = get_top_rate($pair, $type) * 1.01; //Default trade price for given pair
		$amount=$AMOUNT; // Sets amount to GET value
		
		var_dump(bter_query('1/private/placeorder', 
			array(
				'pair' => "$pair",
				'type' => "$type",
				'rate' => "$rate",
				'amount' => "$amount", //Doge trades must be over 1k
				)
			  )
			);
			}
		
		else if($FUNCTION=="cancel"){
		var_dump(bter_query('1/private/cancelorder', array('order_id' => 125811))); //Cancels selected order
		}
		
		else if($FUNCTION=="orderStatus"){
		var_dump(bter_query('1/private/getorder', array('order_id' => 15088))); // Gets the status of order
		}
		
		else if($FUNCTION=="openOrders"){
		var_dump(bter_query('1/private/orderlist')); // Lists all current orders on account
		}
		
	} catch (Exception $e) {
		echo "Error:".$e->getMessage();
		
	} 
	}
	else{
	echo "Enter Pass Code";
	}
?> 
